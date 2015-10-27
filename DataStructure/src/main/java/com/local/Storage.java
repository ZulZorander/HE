package com.local;

/**
 * The most appropriate solution for lookup and insertion amortized efficiency to be O(1) is use of HashTable approach:
 * - data storage consist of 'buckets' (actually the array).
 * - each 'bucket' has simple 'linked list' implementation (array, in which every element has a link to the next element);
 * - while new element is being added to storage -  'backet' index, based on its hash code function is calculated;
 * - element is inserted to the end of  linked list of the current 'bucket'.
 * <p/>
 * Every time when the size of inner linked list is exceeded, it is resized and new array is created instead.
 * Also, when' threshold'(man element count) exceeded defined value, all storage is reindexed and twice as many 'buckets' created are created (with objects redistribution).
 * <p/>
 * It is nor guarantee, that insertion and looping time will be O(1). In worst case scenario, when hashCode function for the class is poor - elements can end up in one 'bucket'.
 * In this case,  all manipulation will take near O(n), where the time will depending of the element count in linked list for this common 'bucket'
 * But, if hashCode function is written properly, then all objects are placed evenly in 'buckets'
 * <p/>
 * So, the average time(amortized efficiency) for such type of storage considered as constant
 *
 * @author dmytro.malovichko
 */
final public class Storage {

    private InnerLinkedList[] buckets = new InnerLinkedList[16]; // use some default bucket count

    // define 'loadFactor', 'threshold ' etc...
    // ...

    {
        for (int i = 0; i < buckets.length; i++) buckets[i] = new InnerLinkedList();
    }

    public Object add(final Object obj) {
        // check if resizing is needed based on threshold value and if so - increase bucket count and reindex storage
        // ...

        Object existingObj = get(obj);
        if (existingObj == null) {
            InnerLinkedList list = buckets[computeIndex(obj.hashCode())];

            return list.addLast(obj);
        }
        return existingObj;
    }

    final Object get(final Object obj) {
        InnerLinkedList list = buckets[computeIndex(obj.hashCode())];

        return list.getElement(obj);
    }

    private int computeIndex(final int hash) {
        return hash & buckets.length - 1; // to ensure that index doesn't exceed the array capacity and it is positive value
    }

    private static class InnerLinkedList {

        private Element elements[] = new Element[2]; // use some default size

        private Object addLast(Object obj) {
            Element newElement = new Element(null, obj.hashCode(), obj);
            for (int i = 0; i < elements.length; i++) {
                Element element = elements[i];
                if (element == null) {
                    elements[i] = newElement;
                } else {
                    if (element.nextElement == null) {
                        // check and make array resizing if required
                        // ...

                        element.nextElement = newElement;
                        elements[i + 1] = newElement;
                        break;
                    }
                }
            }
            return obj;
        }

        private Object getElement(Object obj) {
            for (Element e = elements[0]; e != null; e = e.nextElement) {
                if (e.hash == obj.hashCode() && (e.value == obj || e.value.equals(obj))) {
                    return e.value;
                }
            }
            return null;
        }

        private static class Element {

            private Element nextElement;

            private int hash;

            private Object value;

            public Element(final Element nextElement, final int hash, final Object value) {
                this.nextElement = nextElement;
                this.hash = hash;
                this.value = value;
            }
        }
    }
}
