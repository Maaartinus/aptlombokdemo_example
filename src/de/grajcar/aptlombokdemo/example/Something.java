package de.grajcar.aptlombokdemo.example;

import de.grajcar.aptlombokdemo.ToString;

@ToString(includeFieldNames=true, callSuper=false, doNotUseGetters=true)
public class Something {
	@ToString
	public static class Nested {
		int a = 42;

		@Override
		public String toString() {
			return _Something_Nested_Demohelper.toString(this);
		}
	}

	int x;
	int y;

	@ToString.Include
	private String y() {
		return y>=0 ? "+" + y : "" + y;
	}

	@ToString.Include
	private int z;

	@ToString.Include
	private String z() {
		return z>=0 ? "+" + z : "" + z;
	}

	@Override
	public String toString() {
		return _Something_Demohelper.toString(this);
	}

	public static void main(String[] args) {
		final Something something = new Something();
		something.x = 1;
		something.y = 2;
		something.z = 3;
		final String s = something.toString();
		System.out.println(s);
		System.out.println(new Something.Nested());
	}

}
