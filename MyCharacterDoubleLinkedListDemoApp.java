package lists.mychracterlinkedlsit.doublelinkedlist;

public class MyCharacterDoubleLinkedListDemoApp {
    public static void main(String[] args){
        var list = new MyChracterDoubleLinkedList();
        list.addFirst('A');
        list.addFirst('B');
        list.addFirst('C');
        list.addFirst('D');
        System.out.println(list);
        list.printInReverse();
        System.out.println(list.contains('E')); 
        list.forEach(n -> System.out.println(n + " "));
    }
    
}
