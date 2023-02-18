/**
 * Copyright 2009-2015 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * SPI缓存提供者。<br/>
 * SPI for cache providers.
 * <p>
 * 一个实例的缓存将被创建为每个名称空间。<br/>
 * One instance of cache will be created for each namespace.
 * <p>
 * 缓存的实现必须有一个构造函数接收缓存id作为一个字符串参数。<br/>
 * The cache implementation must have a constructor that receives the cache id as an String parameter.
 * <p>
 * MyBatis会将名称空间作为id传递给构造函数。<br/>
 * MyBatis will pass the namespace as id to the constructor.
 * <p>
 *
 * <pre>
 * public MyCache(final String id) {
 *  if (id == null) {
 *    throw new IllegalArgumentException("Cache instances require an ID");
 *  }
 *  this.id = id;
 *  initialize();
 * }
 * </pre>
 *
 * @author Clinton Begin
 * @date 2023/02/19
 */

public interface Cache {

  /**
   * 得到id
   *
   * @return The identifier of this cache
   */
  String getId();

  /**
   * 设置对象到缓存中去
   *
   * @param key   Can be any object but usually it is a {@link CacheKey}
   * @param value The result of a select.
   */
  void putObject(Object key, Object value);

  /**
   * 得到对象
   *
   * @param key The key
   *
   * @return The object stored in the cache.
   */
  Object getObject(Object key);

  /**
   * 删除对象
   * As of 3.3.0 this method is only called during a rollback
   * for any previous value that was missing in the cache.
   * This lets any blocking cache to release the lock that
   * may have previously put on the key.
   * A blocking cache puts a lock when a value is null
   * and releases it when the value is back again.
   * This way other threads will wait for the value to be
   * available instead of hitting the database.
   *
   * @param key The key
   *
   * @return Not used
   */
  Object removeObject(Object key);

  /**
   * 清除缓存实例
   * Clears this cache instance
   */
  void clear();

  /**
   * 可选的。 调用这个方法并不是核心。
   * Optional. This method is not called by the core.
   *
   * @return 在缓存中存储的元素数量(而不是它的容量)。
   */
  int getSize();

  /**
   * 获取读写锁
   * 可选的。 3.2.6时调用这个方法不再是核心
   * Optional. As of 3.2.6 this method is no longer called by the core.
   * <p>
   * 必须提供任何锁定缓存所需的内部缓存提供者。
   * Any locking needed by the cache must be provided internally by the cache provider.
   *
   * @return A ReadWriteLock
   */
  ReadWriteLock getReadWriteLock();

}