package program;

import java.util.ArrayList;

public class HomeworkSession3 {
    /**
     * Tìm kiếm chuỗi dài nhất trong list và trả về
     * @param list: list đầu vào
     * @return
     */
    public static String findMaxLength(ArrayList<String> list) {
        //TODO: bỏ return và hoàn thiện hàm

        int i = 0;
        int listSize = list.get(0).length();
        for(int j=1; j< list.size(); j++) {
            if(list.get(j).length() > listSize) {
                i = j;
                listSize = list.get(j).length();
            }
        }
        return list.get(i);
    }



    /**
     * Tính tổng độ dài của tất cả các chuỗi trong list và trả về
     * @param list: list đầu vào
     * @return
     */
    public static int findTotalLength(ArrayList<String> list) {
        //TODO: bỏ return và hoàn thiện hàm
        int lengthSum = 0;
        for(int i = 0; i < list.size();i++){
            lengthSum += list.get(i).length();
        }
        return lengthSum;
    }


    public static void main(String[] args) {
        // listString.add() // dua phan tu vao mang
        // listString.size() // lay kich thuoc cua mang
        // listString.get() // lay ra phan tu
        // listString.remove() // bo di phan tu
        ArrayList<String> listString = new ArrayList<>();
        listString.add("Lorem");
        listString.add("Ipsum");
        listString.add("is");
        listString.add("simply");
        listString.add("dummy");
        listString.add("of");
        listString.add("the");
        listString.add("printing");
        listString.add("and");
        listString.add("typesetting");
        listString.add("industry");

        // ví dụ thao tác với mảng
        System.out.println("List string:");
        System.out.println("<<<");
        for (int i = 0; i < listString.size(); i++) {
            String s = listString.get(i);
            System.out.println(s + " - length: " + s.length());
        }
        System.out.println(">>>");

        // in kết quả chạy thử hàm sau khi đã hoàn thiện phần TODO
        System.out.println("Longest string in list");
        String longestString = findMaxLength(listString);
        System.out.println(longestString); // "typesetting"

        System.out.println("Total length of strings in list");
        int totalLength = findTotalLength(listString);
        System.out.println(totalLength); // 58
    }
}
