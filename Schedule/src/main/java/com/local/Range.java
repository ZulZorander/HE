package com.local;

/**
 * Time range abstraction
 *
 * @author dmytro.malovichko
 */
final public class Range implements Comparable<Range> {

	private int start;

	private int end;

	public Range(final int start, final int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public Range setStart(final int start) {
		this.start = start;
		return this;
	}

	public Range setEnd(final int end) {
		this.end = end;
		return this;
	}

    public Range copy() {
        return new Range(start, end);
    }

	@Override
	public int compareTo(final Range otherRange) {
		if (this.start != otherRange.start){
			return this.start - otherRange.start;
		} else if (this.end != otherRange.end){
			return this.end - otherRange.end;
		}
		return 0;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Range range = (Range) o;

		return end == range.end && start == range.start;
	}

	@Override
	public int hashCode() {
		int result = start;
		result = 31 * result + end;
		return result;
	}
}
