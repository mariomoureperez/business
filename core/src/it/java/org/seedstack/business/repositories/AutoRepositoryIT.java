/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.repositories;

import org.seedstack.business.api.domain.Repository;
import org.seedstack.business.repositories.fixtures.DefaultRepoSample;
import org.seedstack.business.repositories.fixtures.DefaultRepoSample2;
import org.seedstack.business.repositories.fixtures.TestAggregate;
import org.seedstack.business.fixtures.domain.customer.Customer;
import org.seedstack.business.fixtures.domain.customer.CustomerId;
import org.seedstack.business.fixtures.infrastructure.persistence.customer.CustomerInMemoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seedstack.seed.it.SeedITRunner;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author pierre.thirouin@ext.mpsa.com
 */
@RunWith(SeedITRunner.class)
public class AutoRepositoryIT {

    @Inject
    Repository<TestAggregate, String> testRepo;

    @Inject @Named("mock")
    Repository<TestAggregate, String> testRepo2;

    @Inject
    Repository<Customer, CustomerId> customerRepo;

    @Test
    public void test() {
        Assertions.assertThat(testRepo).isNotNull();
        Assertions.assertThat(testRepo).isInstanceOf(DefaultRepoSample.class);

        Assertions.assertThat(testRepo2).isNotNull();
        Assertions.assertThat(testRepo2).isInstanceOf(DefaultRepoSample2.class);

        Assertions.assertThat(customerRepo).isNotNull();
        Assertions.assertThat(customerRepo).isInstanceOf(CustomerInMemoryRepository.class);
    }
}
