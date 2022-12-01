/*******************************************************************************
 *     ___                  _   ____  ____
 *    / _ \ _   _  ___  ___| |_|  _ \| __ )
 *   | | | | | | |/ _ \/ __| __| | | |  _ \
 *   | |_| | |_| |  __/\__ \ |_| |_| | |_) |
 *    \__\_\\__,_|\___||___/\__|____/|____/
 *
 *  Copyright (c) 2014-2019 Appsicle
 *  Copyright (c) 2019-2022 QuestDB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 ******************************************************************************/

package io.questdb.network;

public abstract class AbstractMutableIOContext<T extends AbstractMutableIOContext<T>> implements MutableIOContext<T> {
    protected IODispatcher<T> dispatcher;
    protected long fd = -1;

    @Override
    public void clear() {
        this.fd = -1;
        this.dispatcher = null;
    }

    @Override
    public IODispatcher<T> getDispatcher() {
        return dispatcher;
    }

    @Override
    public long getFd() {
        return fd;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T of(long fd, IODispatcher<T> dispatcher) {
        this.fd = fd;
        this.dispatcher = dispatcher;
        return (T) this;
    }
}