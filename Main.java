
public class Main {

	public static void main(String[] args) {
		
		
		testConstructor();
		testAdd();
		testAddIndex();
		testContains();
		testGet();
		testFindFirstOccurrence();
		testFindFirstOccurrenceSince();
		testFindLastOccurrence();
		testRemove();
		testRemoveIndex();
		testRemoveAll();
		testSize();
	}
	private static LinkedListADT<Integer> buildSampleList() {
		LinkedListADT<Integer> list = new LinkedListADT<>();
		list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        return list;
	}
	
	private static void testConstructor() {
		System.out.println("Testing constructor");
		Integer[] nums = {1, 2, 3};
		LinkedListADT<Integer> list = new LinkedListADT<>(nums);
		System.out.println(list); // should print [1, 2, 3]
		
		LinkedListADT<Integer> emptyList = new LinkedListADT<>();
		System.out.println(emptyList); 	//empty constructor	
	}
	
	private static void testAdd() {
		LinkedListADT<Integer> list = buildSampleList();
		System.out.println("Testing add(T elem)");
		list.add(25);
		System.out.println(list); // should print [5, 10, 15, 20, 25]
	}
	
	private static void testAddIndex() {
		LinkedListADT<Integer> list = buildSampleList();
		System.out.println("Testing add(int index, T elem)");
		list.add(0, 1); // add at head
        list.add(2, 7);  // add in middle
        list.add(list.size(), 30);  // add at tail
		System.out.println(list); // should print [1, 5, 7, 10, 15, 20, 30]
	}
	
	private static void testGet() {
		LinkedListADT<Integer> list = buildSampleList();
		System.out.println("Testing get(int index)");
		System.out.println("Element at index 0: "+ list.get(0)); // 5
		System.out.println("Element at index 3: "+ list.get(3)); // 20
	}
	
	private static void testContains() {
		LinkedListADT<Integer> list = buildSampleList();
		System.out.println("Contains 10? "+ list.contains(10)); // true
		System.out.println("Contains 90? "+ list.contains(90)); // false
	}
	
	private static void testFindFirstOccurrence() {
		LinkedListADT<Integer> list = buildSampleList();
		System.out.println("First occurrence of 10: "+ list.findFirstOccurrence(10)); // 1
		System.out.println("First occurrence of 99: "+ list.findFirstOccurrence(99)); //-1
	}
	
	private static void testFindFirstOccurrenceSince() {
		LinkedListADT<Integer> list = buildSampleList();
		System.out.println("Find 10 starting from index 2: "+ list.findFirstOccurrenceSince(2, 10)); // -1
		System.out.println("First 15 starting at index 1: "+ list.findFirstOccurrenceSince(1, 15)); // 2
	}
	
	private static void testFindLastOccurrence() {
		LinkedListADT<Integer> list = buildSampleList();
		System.out.println("Last occurrence of 10: "+ list.findLastOccurrence(10)); // 1
	}
	
	private static void testRemove() {
		LinkedListADT<Integer> list = buildSampleList();
		System.out.println("Testing remove(T elem)");
		System.out.println(list);
		list.remove(10);
		System.out.println("After removing 10: " + list);
	}
	
	private static void testRemoveIndex() {
		LinkedListADT<Integer> list = buildSampleList();
		System.out.println("Testing remove(int index)");
		System.out.println(list);
		list.remove(1);
		System.out.println("After removing from index 1: " + list);
	}
	
	private static void testRemoveAll() {
		LinkedListADT<Integer> list = buildSampleList();
		System.out.println("Testing removeAll(T elem)");
		list.add(5);
        list.add(10);
		System.out.println("Before removing all 5: " +list);
		list.removeAll(5);
		System.out.println("After removing all 5: " + list);
		list.removeAll(99);
		System.out.println("After removing all 99: " + list);
	}
	
	private static void testSize() {
		LinkedListADT<Integer> list = buildSampleList();
		System.out.println("Testing size()");
		System.out.println(list);
		System.out.println("Size: " + list.size());
	}

}
