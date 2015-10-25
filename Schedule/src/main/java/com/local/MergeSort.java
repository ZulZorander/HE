package com.local;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Implementation of MergeSort sorting algorithm
 *
 * @author dmytro.malovichko
 */
public final class MergeSort {

	private final Range[] src;

	private Range[] tmp;

	public MergeSort(@NotNull final List<Range> ranges) {
        src = new Range[ranges.size()];
        tmp = new Range[ranges.size()];
		ranges.toArray(src);
	}

	public List<Range> sort() {
		if (src.length == 0) return Collections.emptyList();
		if (src.length == 1) return Arrays.asList(src);

        doSort(0, src.length - 1);

		return Arrays.asList(src);
	}

	private void doSort(final int start, final int end){
		if (start < end) {
			// find the middle of the list
			int middle = start + (end - start) / 2;

			// recursively sort and merge parts
			doSort(start, middle);
			doSort(middle + 1, end);

			doMerge(start, middle, end);
		}
	}

	private void doMerge(final int start, final int middle, final int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = src[i];
        }

		int leftStart = start;
		int rightStart = middle + 1;
		int index = start;

		// compare elements from both parts and put into src list
		while (leftStart <= middle && rightStart <= end) {
			Range first = tmp[leftStart];
			Range second = tmp[rightStart];
			if (first.compareTo(second) <= 0) {
                src[index] = first;
				leftStart++;
			} else {
                src[index] = second;
				rightStart++;
			}
			index++;
		}

        // fill in the remaining left part
		while (leftStart <= middle) {
            src[index] = tmp[leftStart];
			leftStart++;
			index++;
		}

        // fill in the remaining right part
        while (rightStart <= end) {
            src[index] = tmp[rightStart];
            rightStart++;
            index++;
        }
	}
}
