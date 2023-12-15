import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Describe a method for performing a card shuffle of a list of 2n elements,
 * by converting it into two lists. A card shuffle is a permutation where a list L is cut into two lists,
 * L1 and L2, where L1 is the first half of L and L2 is the second half of L,
 * and then these two lists are merged into one by taking the first element in L1, then the first element in L2,
 * followed by the second element in L1, the second element in L2, and so on.
 * @author Umair Alvi
 *
 */
public class CardShuffle{
static int x =0;
static int j = 0;
public static List shuffle(List input){
List L1 = new ArrayList(input.size()/2);
List L2 = new ArrayList(input.size()/2);
return split(input,input.size(), L1, L2);
}
public static List split(List input, int index, List L1, List L2){
for(int i =0; i <input.size()/2; i++){
L1.add(input.get(i));
}
for(int i=input.size()/2; i<input.size(); i++){
L2.add(input.get(i));
}
return merge(input,L1,L2);
}
public static List merge(List input, List L1, List L2){
for(int i =0; i<input.size();i =i+2){
if(x<L1.size()){
input.set(i, L1.get(x));
x++;
}
}
for(int i=1; i<input.size(); i= i+2 ){
if(j<L2.size()){
input.set(i,L2.get(j));
j++;
}
}
return input;
}
public static void main(String[] args){
List in = new ArrayList();
System.out.println("Please add elements to list (Note: after adding please enter -99)");
Scanner src = new Scanner(System.in);
int element = src.nextInt();
while(element != -99){
in.add(element);
element = src.nextInt();
}
System.out.println("The List you created just now is:");
System.out.println(in);
System.out.println("After Shuffling the List:");
System.out.println(shuffle(in));
}

}