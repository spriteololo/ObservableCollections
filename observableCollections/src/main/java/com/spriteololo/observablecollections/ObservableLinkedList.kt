package com.spriteololo.observablecollections

import java.util.*

class ObservableLinkedList<E> : LinkedList<E> {
    private var callback: LinkedListListener<E>? = null

    fun setListener(listener: LinkedListListener<E>) {
        callback = listener
    }

    constructor() : super()
    constructor(c: Collection<E>) : super(c)

    override fun addFirst(e: E) {
        super.addFirst(e).also {
            callback?.onInsertItem(e, 0)
        }
    }

    override fun removeFirst(): E {
        return super.removeFirst().also { item ->
            callback?.onRemovedItem(item, 0)
        }
    }

    override fun pollFirst(): E? {
        return super.pollFirst().also { item ->
            if (item != null) callback?.onRemovedItem(item, 0)
        }
    }

    override fun addAll(index: Int, elements: Collection<E>): Boolean {
        val snapshot = toList()
        return super.addAll(index, elements).also {
            callback?.onInsertCollection(index, snapshot)
        }
    }

    override fun clear() {
        super.clear().also {
            callback?.onCleared()
        }
    }

    override fun addLast(e: E) {
        super.addLast(e).also {
            callback?.onInsertItem(e, size)
        }
    }

    override fun add(element: E): Boolean {
        return super.add(element).also {
            if (it) callback?.onInsertItem(element, size)
        }
    }

    override fun add(index: Int, element: E) {
        super.add(index, element).also {
            callback?.onInsertItem(element, index)
        }
    }

    override fun removeLastOccurrence(o: Any?): Boolean {
        return super.removeLastOccurrence(o).also {
            if (it) callback?.onRemovedItem(o as E)
        }
    }

    override fun removeAt(index: Int): E {
        return super.removeAt(index).also { item ->
            callback?.onRemovedItem(item, index)
        }
    }

    override fun remove(element: E): Boolean {
        return super.remove(element).also {
            if (it) callback?.onRemovedItem(element)
        }
    }

    override fun removeLast(): E {
        return super.removeLast().also { item ->
            callback?.onRemovedItem(item)
        }
    }

    override fun set(index: Int, element: E): E {
        return super.set(index, element).also {
            callback?.onChanged(element, index)
        }
    }

    override fun pollLast(): E? {
        return super.pollLast().also { item ->
            if (item != null) callback?.onRemovedItem(item)
        }
    }

    override fun poll(): E? {
        return super.poll().also { item ->
            if (item != null) callback?.onRemovedItem(item)
        }
    }
}