import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static ArrayList<Integer> append(ArrayList<Integer> a,ArrayList<Integer> b){
        ArrayList<Integer> c = new ArrayList<>();
        c.addAll(a);
        c.addAll(b);
        return c;
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> a,ArrayList<Integer> b){
        ArrayList<Integer> c = new ArrayList<>();
        if(a.size() == b.size()){
        for (int i = 0;i<a.size();i++){
            c.add(a.get(i));
            c.add(b.get(i));
        }
        }
        if(a.size() < b.size()){
            for (int i = 0;i<b.size();i++){
                if(i<a.size()) {
                    c.add(a.get(i));
                    c.add(b.get(i));
                }
                else {
                    c.add(b.get(i));
                }
            }
        } else if (a.size() > b.size()) {
            for (int i = 0;i<a.size();i++){
                if(i<b.size()) {
                    c.add(b.get(i));
                    c.add(a.get(i));
                }
                else {
                    c.add(a.get(i));
                }
            }
        }
        return c;
    }
    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> a,ArrayList<Integer> b){
        ArrayList<Integer> c = merge(a,b);
        Collections.sort(c);
        return c;
    }
    public static ArrayList<Integer> reversed(ArrayList<Integer> a){
        ArrayList<Integer> c = (ArrayList<Integer>) a.clone();
        int temp = a.get(a.size()-1);
//        for(int i = 0;i<a.size();i++){
//            c.set(a.size()-i-1, a.get(i));
//        }
        if(a.size()%2==0){
            for(int i = 0;i<a.size()/2;i++){
                a.set(a.size()-i-1,a.get(i));
                a.set(i,temp);
                temp = a.get(a.size()-2-i);
            }
        }
        else {
            for(int i = 0;i<(a.size()+1)/2;i++){
                if(i != (a.size()+1)/2) {
                    a.set(a.size() - i - 1, a.get(i));
                    a.set(i, temp);
                    temp = a.get(a.size() - 2 - i);
                }
            }
        }
        return a;
    }
    public static void void_reversed(ArrayList<Integer> a){
        ArrayList<Integer> c = (ArrayList<Integer>) a.clone();
        int temp = a.get(a.size()-1);
//        for(int i = 0;i<a.size();i++){
//            c.set(a.size()-i-1, a.get(i));
//        }
        if(a.size()%2==0){
            for(int i = 0;i<a.size()/2;i++){
                a.set(a.size()-i-1,a.get(i));
                a.set(i,temp);
                temp = a.get(a.size()-2-i);
            }
        }
        else {
            for(int i = 0;i<(a.size()+1)/2;i++){
                if(i != (a.size()+1)/2) {
                    a.set(a.size() - i - 1, a.get(i));
                    a.set(i, temp);
                    temp = a.get(a.size() - 2 - i);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(4);
        a.add(9);
        ArrayList<Integer> b = new ArrayList<>();
        
        void_reversed(a);
        System.out.print(a);
    }
}
