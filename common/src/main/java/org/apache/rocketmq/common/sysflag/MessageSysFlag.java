/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.common.sysflag;

//消息系统标志位
public class MessageSysFlag {
    //压缩标志位 00000001
    public final static int COMPRESSED_FLAG = 0x1;
    //多tag标志位 00000010
    public final static int MULTI_TAGS_FLAG = 0x1 << 1;
    //无事务 00000000
    public final static int TRANSACTION_NOT_TYPE = 0;
    //事务准备 00000100
    public final static int TRANSACTION_PREPARED_TYPE = 0x1 << 2;
    //事务提交 00001000
    public final static int TRANSACTION_COMMIT_TYPE = 0x2 << 2;
    //事务回滚 00001100
    public final static int TRANSACTION_ROLLBACK_TYPE = 0x3 << 2;
    //00010000  消息产生host是ipv6
    public final static int BORNHOST_V6_FLAG = 0x1 << 4;
    //00100000  消息存储host是ipv6
    public final static int STOREHOSTADDRESS_V6_FLAG = 0x1 << 5;

    public static int getTransactionValue(final int flag) {
        return flag & TRANSACTION_ROLLBACK_TYPE;
    }

    public static int resetTransactionValue(final int flag, final int type) {
        return (flag & (~TRANSACTION_ROLLBACK_TYPE)) | type;
    }

    public static int clearCompressedFlag(final int flag) {
        return flag & (~COMPRESSED_FLAG);
    }

}
