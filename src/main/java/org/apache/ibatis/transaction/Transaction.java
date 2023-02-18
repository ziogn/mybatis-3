/**
 *    Copyright 2009-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务
 * Wraps a database connection.
 * Handles the connection lifecycle that comprises: its creation, preparation, commit/rollback and close.
 * <p>
 * 包装数据库连接，处理连接生命周期：创建、准备、提交/回滚和关闭
 *
 * @author Clinton Begin
 * @date 2023/02/19
 */
public interface Transaction {

  /**
   * 获得连接
   * Retrieve inner database connection<br/>
   * 获取内部数据库连接
   *
   * @return DataBase connection
   *
   * @throws SQLException sqlexception异常
   */
  Connection getConnection() throws SQLException;

  /**
   * 提交
   * Commit inner database connection.<br/>
   * 提交内部数据库连接
   *
   * @throws SQLException sqlexception异常
   */
  void commit() throws SQLException;

  /**
   * 回滚
   * Rollback inner database connection.<br/>
   * 回滚内部数据库连接
   *
   * @throws SQLException sqlexception异常
   */
  void rollback() throws SQLException;

  /**
   * 关闭
   * Close inner database connection.<br/>
   * 关闭数据库连接
   *
   * @throws SQLException sqlexception异常
   */
  void close() throws SQLException;

  /**
   * 会超时
   * Get transaction timeout if set<br/>
   * 获取设置的超时时间，如果有设置的话
   *
   * @return {@link Integer}
   *
   * @throws SQLException sqlexception异常
   */
  Integer getTimeout() throws SQLException;
  
}
