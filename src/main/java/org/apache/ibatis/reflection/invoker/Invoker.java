/**
 *    Copyright 2009-2015 the original author or authors.
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
package org.apache.ibatis.reflection.invoker;

import java.lang.reflect.InvocationTargetException;

/**
 * 调用者
 *
 * @author Clinton Begin
 * @date 2023/02/20
 */
public interface Invoker {
  /**
   * 调用
   *
   * @param target 目标
   * @param args   arg游戏
   *
   * @return {@link Object}
   *
   * @throws IllegalAccessException    非法访问异常
   * @throws InvocationTargetException 调用目标异常
   */
  Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException;

  /**
   * 获取相关类型
   *
   * @return {@link Class}<{@link ?}>
   */
  Class<?> getType();
}
