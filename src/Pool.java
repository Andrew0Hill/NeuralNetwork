import java.util.ArrayList;

/**
 * Created by Andrew on 4/24/2017.
 */
public class Pool {
    double sum;
    ArrayList<Unit> members;
    Pool(){
        sum = 0;
        members = new ArrayList<>();
    }

    void addMember(Unit member){
        members.add(member);
    }
    void updatesum(){
        sum = 0;
        for(Unit member : members){
            sum += member.output;
        }
    }
    void display(){
        for(Unit member : members){
            System.out.println("Member: " + member.name + "Act: " + member.activation);
        }
    }
}
