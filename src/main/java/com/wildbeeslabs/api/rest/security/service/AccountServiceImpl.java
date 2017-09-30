/*
 * The MIT License
 *
 * Copyright 2017 Pivotal Software, Inc..
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.wildbeeslabs.api.rest.security.service;

import com.wildbeeslabs.api.rest.common.security.UserCredentials;
import com.wildbeeslabs.api.rest.security.model.Account;
import com.wildbeeslabs.api.rest.security.repository.AccountRepository;
import com.wildbeeslabs.api.rest.security.service.interfaces.IAccountService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * Account REST Application Service implementation {@link Account}
 *
 * @author Alex
 * @version 1.0.0
 * @since 2017-08-08
 * @param <T>
 */
@Service("accountService")
@Transactional
public class AccountServiceImpl<T extends Account> extends JpaBaseServiceImpl<T, Long, AccountRepository<T>> implements IAccountService<T> {

    @Override
    public List<? extends T> findByUser(final UserCredentials user) {
        return getRepository().findByUser(user);
    }

    @Override
    public Optional<? extends T> findByUuid(final UUID uuId) {
        return getRepository().findByUuid(uuId);
    }
}
