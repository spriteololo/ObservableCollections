package com.spriteololo.observablecollections

import java.util.*

class ObservableArrayList<E> : ArrayList<E> {
    private var callback: ArrayListListener<E>? = null

    fun setListener(listener: ArrayListListener<E>) {
        callback = listener
    }

    constructor() : super()
    constructor(c: Collection<E>) : super(c)
    constructor(initialCapacity: Int) : super(initialCapacity)

    override fun add(element: E): Boolean {
        return super.add(element).also {
            callback?.onInsertItem(element, size)
        }
    }

    override fun add(index: Int, element: E) {
        return super.add(index, element).also {
            callback?.onInsertItem(element, index)
        }
    }

    override fun addAll(elements: Collection<E>): Boolean {
        val snapshot = toList()
        return super.addAll(elements).also {
            if (it) callback?.onInsertCollection(snapshot.size, snapshot)
        }
    }

    override fun addAll(index: Int, elements: Collection<E>): Boolean {
        val snapshot = toList()
        return super.addAll(index, elements).also {
            if (it) callback?.onInsertCollection(index, snapshot)
        }
    }

    override fun clear() {
        callback?.onCleared()
        super.clear()
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        val snapshot = toList()
        return super.removeAll(elements).also {
            if (it) callback?.onRemovedItems(snapshot)
        }
    }

    override fun removeRange(fromIndex: Int, toIndex: Int) {
        return super.removeRange(fromIndex, toIndex).also {
            callback?.onRemovedItems(fromIndex, toIndex)
        }
    }

    override fun removeAt(index: Int): E {
        return super.removeAt(index).also { item ->
            callback?.onRemovedItem(item, index)
        }
    }

    override fun remove(element: E): Boolean {
        return super.remove(element).also {
            callback?.onRemovedItem(element)
        }
    }

    override fun set(index: Int, element: E): E {
        return super.set(index, element).also {
            callback?.onChanged(element, index)
        }
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        val snapshot = toList()
        return super.retainAll(elements).also {
            if (it) callback?.onRemovedItems(snapshot)
        }
    }
}