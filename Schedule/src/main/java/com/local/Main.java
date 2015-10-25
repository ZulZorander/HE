package com.local;

import java.util.LinkedList;
import java.util.List;


/**
 * @author dmytro.malovichko
 */
final public class Main {

	public static void main(String[] args) {
		List<Range> schedules = new LinkedList<>();
		schedules.add(new Range(6, 7));
		schedules.add(new Range(9, 10));
        schedules.add(new Range(13, 14));
		schedules.add(new Range(8, 10));
        schedules.add(new Range(22, 24));
        schedules.add(new Range(12, 15));
        schedules.add(new Range(21, 23));
		schedules.add(new Range(8, 9));
        schedules.add(new Range(12, 13));
        schedules.add(new Range(9, 11));
		schedules.add(new Range(15, 17));
		schedules.add(new Range(15, 16));

		List<Range> mergeResults = new Schedule(schedules).mergeAndSort();

        System.out.println("Input:");
        List<Range> sorted = new MergeSort(schedules).sort();
        for (Range range : sorted) {
            System.out.println(range.getStart() + " " + range.getEnd());
        }
        System.out.println();

		System.out.println("Merge results:");
		for (Range range : mergeResults) {
			System.out.println(range.getStart() + " " + range.getEnd());
		}
	}

}
