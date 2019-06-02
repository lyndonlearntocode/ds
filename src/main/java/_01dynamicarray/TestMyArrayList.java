package _01dynamicarray;

/**
 * @Author: Lyndon_Mi
 * @Date: 6/1/2019 15:21
 * @Description:
 */
public class TestMyArrayList {

    public static void main(String[] args) {
        MyArrrayList<Integer> myArrrayList = new MyArrrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            myArrrayList.add(i);
        }
        for (int i = 0; i < 10; i++) {
            myArrrayList.add(i * 2, i + 100);
        }
        for (int i = 0; i < myArrrayList.size(); i++) {
            System.out.println(myArrrayList.get(i));
        }
        for (int i = 0; i < myArrrayList.size(); i++) {
            System.out.println(myArrrayList.set(i, myArrrayList.get(i) + 1));
        }
        for (int i = 0; i < myArrrayList.size(); i++) {
            System.out.println(myArrrayList.remove(0));
        }
        for (int i = 0; i < myArrrayList.size(); i++) {
            System.out.println(myArrrayList.get(i));
        }

    }

}
