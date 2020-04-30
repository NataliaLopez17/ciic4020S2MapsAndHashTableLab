package ciic4020.hashtable;

import java.util.Iterator;

import ciic4020.map.Map;

public class HashSet<E> implements Set<E> {

	private Map<E, Object> hashtable;

	public HashSet(int initialCapacity) {
		this.hashtable = new HashTableSC<E, Object>(initialCapacity, new SimpleHashFunction<E>());
	}

	public Iterator<E> iterator() {
		return hashtable.getKeys().iterator();
	}

	@Override
	public boolean add(E obj) {
		if (this.isMember(obj)) {
			return false;
		}
		this.hashtable.put(obj, new Object());
		System.out.println("added: " + obj);
		return true;
	}

	@Override
	public boolean isMember(E obj) {
		return this.hashtable.get(obj) != null;
	}

	@Override
	public boolean remove(E obj) {
		return this.hashtable.remove(obj) != null;
	}

	@Override
	public boolean isEmpty() {
		return this.hashtable.isEmpty();
	}

	@Override
	public int size() {
		return this.hashtable.size();
	}

	@Override
	public void clear() {
		int size = this.hashtable.size();
		while (!this.isEmpty()) {
			size--;
		}
	}

	@Override
	public Set<E> union(Set<E> S2) {
		HashSet<E> S3 = new HashSet<E>(this.size());
		for (E obj : S2) {
			if (!S3.isMember(obj))
				S3.add(obj);
		}
		for (E e : this) {
			S3.add(e);
		}
		return S3;
	}

	@Override
	public Set<E> difference(Set<E> S2) {
		HashSet<E> S3 = new HashSet<E>(this.size());
		for (E obj : this) {
			if (!S2.isMember(obj)) {
				S3.add(obj);
			}
		}
		return S3;
	}

	@Override
	public Set<E> intersection(Set<E> S2) {
		return this.difference(this.difference(S2));
	}

	@Override
	public boolean isSubSet(Set<E> S2) {
		for (E obj : S2) {
			if (!this.hashtable.containsKey(obj)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equals(Set<E> S2) {
		return (this.difference(S2).isEmpty());
	}

}
