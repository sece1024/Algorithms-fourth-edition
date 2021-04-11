package test;

import myPackage.Stack;

// 测试链表栈
// 固定输入
public class StackTest01 {
    public static void main(String[] args){
        String[] s = {"hello", "my", "name", "is"};
        Stack st = new Stack();
        for(String item:s){
            st.push(item);
        }
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}
