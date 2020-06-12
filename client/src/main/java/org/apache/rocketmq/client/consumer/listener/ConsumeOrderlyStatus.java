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
package org.apache.rocketmq.client.consumer.listener;

//顺序消费状态值
public enum ConsumeOrderlyStatus {
    /**
     * Success consumption
     */
    SUCCESS,//成功
    /**
     * Rollback consumption(only for binlog consumption)
     */
    @Deprecated
    ROLLBACK,
    /**
     * Commit offset(only for binlog consumption)
     */
    @Deprecated
    COMMIT,
    /**
     * Suspend current queue a moment
     */
    //失败的话是返回的SUSPEND_CURRENT_QUEUE_A_MOMENT，而不是RECONSUME_LATER
    // 这是因为对于顺序消息,消费失败是不会返回给broker重新投递，这样会破坏顺序
    SUSPEND_CURRENT_QUEUE_A_MOMENT;//暂停一下
}
