package org.openstack4j.fusionapi.compute;

import org.openstack4j.common.RestService;

/**
 * @author: liuxs
 * @description: Compute Operations API
 * @date: Created in 下午6:23  2018/8/16
 */
public interface FcComputeService extends RestService {

    /**
     * Flavor Service API
     *
     * @return the flavor service
     */
    FcFlavorService flavors();

}
