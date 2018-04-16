package de.grajcar.aptlombokdemo.example;

import de.grajcar.aptlombokdemo.MakeComparable;

@MakeComparable
public class SomethingMakeComparable implements Comparable<SomethingMakeComparable> {
	String second;

	@MakeComparable.Include(rank=-1)
	int first() {
		return second==null ? -1 : second.length();
	}

	@Override public int compareTo(SomethingMakeComparable that) {
		return _SomethingMakeComparable_MakeComparableHelper.compare(this, that);
	}

	public static void main(String[] args) {
		final SomethingMakeComparable a = new SomethingMakeComparable();
		final SomethingMakeComparable b = new SomethingMakeComparable();
		a.second = "aa";
		b.second = "aa";
		System.out.println("compareTo -> " + a.compareTo(b));
	}
}
