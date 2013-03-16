import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class sort_array {
	public static void main(String[] args){
		int[] intArray = {1,1,1,2,2,3,4,4,4,4,4,5,6,7,8};// Given array
		ArrayList<Integer> listArr = new ArrayList<Integer>();
		for(int i=0;i<intArray.length;i++)
			listArr.add(intArray[i]);
		arraysorted(listArr);
	}
	
	public static void arraysorted(ArrayList<Integer> listArr){
		HashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		for(int i=0;i<listArr.size();i++){
			Integer fre = map.get(listArr.get(i));
			map.put(listArr.get(i), (fre==null)?1:fre+1);
		}
		ArrayList<Entry<Integer, Integer>> sort = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		Comparator<Entry<Integer, Integer>> comparator = new Comparator<Entry<Integer, Integer>>(){
			@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
		};
		Collections.sort(sort, comparator);
	//	System.out.println(sort);
		Collections.reverse(sort);
		Iterator<Entry<Integer, Integer>> iterator = sort.iterator();
		while(iterator.hasNext()){
			Entry<Integer,Integer> entries = (Entry<Integer,Integer>)iterator.next();
			System.out.println(entries.getKey());
		}
	}
}
