package com.local;

import com.sun.istack.internal.NotNull;

import java.util.*;

/**
 * Used to manage schedule
 *
 * @author dmytro.malovichko
 */
final public class Schedule {

	private List<Range> src;

    public Schedule(@NotNull final List<Range> ranges) {
        src = new ArrayList<>(ranges);
    }

    /**
     * Sort and merge schedule
     *
     * @return merged schedule
     */
    public List<Range> mergeAndSort() {
		if (src.isEmpty()) return Collections.emptyList();
		if (src.size() == 1) return src;

		// sort collection to achieve linear algorithm speed
        src = new MergeSort(src).sort();

		return doMerge();
	}

    private List<Range> doMerge() {
        final List<Range> res = new ArrayList<>();
        Range current = src.get(0).copy();
        res.add(current);
        int index = 1;
        while(index < src.size()){
            final Range next = src.get(index);
            if(next.getStart() <= current.getEnd() ) {
                // overlaps
                current.setEnd(Math.max(current.getEnd(), next.getEnd()));
            } else {
                // no overlaps
                current = next.copy();
                res.add(current);
            }
            index++;
        }

        return res;
    }
}
