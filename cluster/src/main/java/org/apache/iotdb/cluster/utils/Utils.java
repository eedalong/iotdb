/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.iotdb.cluster.utils;

import java.util.ArrayList;
import java.util.List;
import org.apache.iotdb.cluster.entity.raft.RaftNode;

public class Utils {

  private Utils(){}

  public static List<RaftNode> convertNodesToRaftNodeList(String[] nodes) {
    List<RaftNode> nodeList = new ArrayList<>(nodes.length);
    for (int i = 0; i < nodes.length; i++) {
      nodeList.add(RaftNode.parseRaftNode(nodes[i]));
    }
    return nodeList;
  }

  public static int getIndexOfIpFromRaftNodeList(String ip, List<RaftNode> nodeList) {
    for (int i = 0; i < nodeList.size(); i++) {
      if (nodeList.get(i).getIp().equals(ip)) {
        return i;
      }
    }
    return -1;
  }
}
