package de.grajcar.aptlombokdemo.example;

import de.grajcar.aptlombokdemo.ToString;

@ToString(includeFieldNames=true, callSuper=false, doNotUseGetters=true)
public class SomethingToString {
	@ToString
	public static class Nested {
		static int a = 42;

		@Override
		public String toString() {
			return _SomethingToString_Nested_ToStringHelper.toString(this);
		}
	}

	int x;
	int y;

	@ToString.Include
	private String y() {
		return y>=0 ? "+" + y : "" + y;
	}

	@ToString.Include // needed as the field would be excluded by including an equally called method
	private int z;

	@ToString.Include
	private String z() {
		return z>=0 ? "+" + z : "" + z;
	}

	@ToString.Include(name="myLongField")
	long n;

	String s;

	@Override
	public String toString() {
		return _SomethingToString_ToStringHelper.toString(this);
	}

	public static void main(String[] args) {
		final SomethingToString something = new SomethingToString();
		something.x = 1;
		something.y = 2;
		something.z = 3;
		something.n = 4;
		final String s = something.toString();
		System.out.println(s);
		System.out.println(new SomethingToString.Nested());
	}
}
