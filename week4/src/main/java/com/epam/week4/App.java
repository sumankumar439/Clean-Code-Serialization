package com.epam.week4;

/**
 * Hello world!
 *
 */
class CustomList<T>
{
     static class Node<T>
     {
    	 T value;
    	 Node<T> prev=null;
    	 Node<T> next=null;
    	 Node(T value)
    	 {
    		 this.value=value;
    	 }
     }
 
     Node<T> root=null;
     Node<T> tail=null;
     
     public void addFront(T element)
     {
    	 Node<T> n=new Node<T>(element);
    	 if(this.root==null)
    	 {
    		 this.root=n;
    		 this.tail=n;
    	 }
    	 else
    	 {
    		 this.root.prev=n;
    		 n.next=this.root;
    		 this.root=this.root.prev;
    	 }
     }
     public void addBack(T element)
     {
    	 Node<T> n=new Node<T>(element);
    	 if(this.tail==null)
    	 {
    		 this.root=n;
    		 this.tail=n;
    	 }
    	 else
    	 {
    		 this.tail.next=n;
    		 n.prev=this.tail;
    		 this.tail=this.tail.next;
    	 }
     }
     private void condition()
     {
    	 if(this.root==null)
    	 {
    		 System.out.println("EMPTY! -- Elements cannot be deleted");
    		 return;
    	 }
    	 if(this.root.equals(this.tail))
    	 {
    		 System.out.println("REMOVED : "+this.root.value);
    		 this.root=null;
    		 this.tail=null;
    		 return;
    	 }
     }
     public void delFront()
     {
    	 condition();
		 Node<T> temp=this.root;
		 this.root=this.root.next;
		 temp.next=null;
		 this.root.prev=null;
		 System.out.println("REMOVED : "+temp.value);
     }
     public void delBack()
     {
    	 condition();
    	 Node<T> temp=this.tail;
    	 this.tail=this.tail.prev;
    	 temp.prev=null;
    	 this.tail.next=null;
    	 System.out.println("REMOVED : "+temp.value);
     }
     public void delElement(T element)
     {
    	 if(this.root==null)
    		 System.out.println("EMPTY! -- Elements cannot be deleted");
    	 else if(this.root == this.tail)
    	 {
    		 if(this.root.value.equals(element))
    		 {
    			 System.out.println("REMOVED : "+this.root.value);
    			 this.root=null;
    			 this.tail=null;
    		 }
    		 else
    		 {
    			 System.out.println(element+" cannot be deleted -- It is not present in list");
    		 }
    	 }
    	 else
    	 {
    		 Node<T> temp=this.root,pr=this.root;
    		 while(temp!=null)
    		 {
    			 pr=temp;
    			 if(temp.value.equals(element))
    				 break;
    			 else
    				 temp=temp.next;
    		 }
    		 if(temp==null)
    			 System.out.println(element+" cannot be deleted -- It is not present in list");
    		 else
    		 {
    			 temp.prev.next=temp.next;
    			 temp.next.prev=temp.prev;
    			 temp.next=null;
    			 temp.prev=null;
    			 System.out.println("REMOVED  : "+element);
    		 }
    	 }
     }
     public void search(T element)
     {
    	 if(this.root==null)
    		 System.out.println("EMPTY! -- cannot search");
    	 else
    	 {
    		 Node<T> temp=this.root;
    		 while(temp!=null)
    		 {
    			 if(temp.value.equals(element))
    			 {
    				 System.out.print(element+" is present");
    				 return;
    			 }
    		 }
    		 System.out.print(element+" is not present"); 
    	 }
     }
     public void printElementsAS()
     {
    	 if(this.root==null)
    		 System.out.println("EMPTY! -- There are no elements");
    	 else
    	 {
    		 Node<T> temp=this.root;
    		 System.out.println("Ascending order : ");
    		 while(temp!=null)
    		 {
    			 System.out.print(temp.value+",");
    			 temp=temp.next;
    		 }
    		 System.out.println();
    	 }
     }
     public void printElementsDS()
     {
    	 if(this.root==null)
    		 System.out.println("EMPTY! -- There are no elements");
    	 else
    	 {
    		 Node<T> temp=this.tail;
    		 System.out.println("Descending order : ");
    		 while(temp!=null)
    		 {
    			 System.out.print(temp.value+",");
    			 temp=temp.prev;
    		 }
    		 System.out.println();
    	 }
     }
     public void clear()
     {
    	 System.out.println("All elements are cleared!!!!!!");
    	 this.root=null;
    	 this.tail=null;
     }
}


public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("\n\nCustom List Implementaiton--type--: String\n");
		CustomList<String> list2=new CustomList<String>();
		String s[]= {"this","is","the","initialization","and","starting","of","the","custom","list","of","strings"};
		for(int i=0;i<s.length;i++)
			list2.addBack(s[i]);
		list2.printElementsAS();
		list2.addFront("StartingOfCollectionTask");
		list2.addBack("EndingOfCollectionTask");
		list2.printElementsAS();
		list2.printElementsDS();
		list2.delBack();
		list2.delFront();
		list2.delElement("initialization");
		list2.delElement("custom");
		list2.printElementsAS();
		list2.clear();
		list2.printElementsAS();   
    	System.out.println("Custom List Implementaiton--type--: Integer\n");
		CustomList<Integer> list1=new CustomList<Integer>();
		for(int i=10;i<=30;i++)
			list1.addBack(i);
		list1.addFront(48);
		list1.addBack(488);
		list1.printElementsAS();
		list1.printElementsDS();
		list1.delBack();
		list1.delFront();
		list1.delElement(21);
		list1.delElement(45);
		list1.printElementsAS();
		list1.clear();
		list1.printElementsAS(); 
    }
}

