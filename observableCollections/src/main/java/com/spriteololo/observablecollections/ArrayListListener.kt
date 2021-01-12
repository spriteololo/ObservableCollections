package com.spriteololo.observablecollections

import android.util.Log
import com.spriteololo.observablecollections.BaseListener.Companion.functionNotUsed

interface ArrayListListener<E> : BaseListener {
    override val TAG
        get() = "ObservableLinkedList"

    fun onChanged(item: E, index: Int) {
        Log.i(TAG, "$functionNotUsed onChanged")
    }

    fun onInsertItem(item: E, index: Int) {
        Log.i(TAG, "$functionNotUsed onInsertItem")
    }

    fun onInsertCollection(index: Int, oldSnapshot: Collection<E>) {
        Log.i(TAG, "$functionNotUsed onInsertCollection")
    }

    fun onCleared() {
        Log.i(TAG, "$functionNotUsed onCleared")
    }

    fun onRemovedItem(oldSnapshot: Collection<E>) {
        Log.i(TAG, "$functionNotUsed onRemovedItem")
    }

    fun onRemovedItem(item: E, index: Int) {
        Log.i(TAG, "$functionNotUsed onRemovedItem")
    }

    fun onRemovedItems(oldSnapshot: Collection<E>) {
        Log.i(TAG, "$functionNotUsed onRemovedItems")
    }

    fun onRemovedItems(fromIndex: Int, toIndex: Int) {
        Log.i(TAG, "$functionNotUsed onRemovedItems")
    }
}