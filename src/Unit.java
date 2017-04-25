import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Andrew on 4/24/2017.
 */

public class Unit {
    // Constant Value Declarations
    static final double minact = -0.2;
    static final double rest = -0.1;
    static final double thresh = 0.0;
    static final double decay = 0.1;
    static final double maxact = 1.0;
    static final double alpha = 0.1;
    static final double gamma = 0.1;
    static final double estr = 0.4;

    static HashMap<String,Unit> unitByName = new HashMap<>();
    String name;
    Pool pool;
    double extinp;
    double activation;
    double output;
    ArrayList<Unit> exciters;
    double newact;

    Unit(String iName, Pool iPool){
        name = iName;
        pool = iPool;
        reset();
        exciters = new ArrayList<>();
        unitByName.put(iName,this);
    }
    void reset(){
        setExtinp(0.0);
        setActivation(rest);
    }
    void setExtinp(double weight){
        extinp = weight;
    }
    void setActivation(double val){
        activation = val;
        output = Math.max(thresh,val);
    }
    void addExciter(Unit unit){
        exciters.add(unit);
    }
    void removeExciter(Unit unit){
        exciters.remove(unit);
    }
    void computeNewAct(){
        double ai = activation;
        double plus = 0;
        for(Unit exc : exciters){
            plus += exc.output;
        }
        double minus = pool.sum - output;
        double netinput = alpha*plus - gamma*minus + estr*extinp;
        ai = (netinput > 0) ? (maxact - ai)*netinput - decay*(ai-rest)+ai : (ai-maxact)*netinput - decay*(ai-rest)+ai;

        newact = Math.max(Math.min(ai,maxact),minact);
    }
    void commitNewAct(){
        setActivation(newact);
    }
}
