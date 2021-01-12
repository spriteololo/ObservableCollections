package com.spriteololo.observablecollections

import android.util.Log
import com.spriteololo.observablecollections.BaseListener.Companion.functionNotUsed

interface LinkedListListener<E> : BaseListener {
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

    fun onRemovedItem(item: E) {
        Log.i(TAG, "$functionNotUsed onRemovedItem")
    }

    fun onRemovedItem(item: E, index: Int) {
        Log.i(TAG, "$functionNotUsed onRemovedItem")
    }
}