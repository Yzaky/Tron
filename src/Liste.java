public interface Liste {

	int size();

	void append(Object o);

	void prepend(Object o);

	Object getFirst();

	Object getLast();

	Object removeFirst();

	Object get(int position);

	void set(int position, Object o);
}
