package org.openstack4j.fusionapi.compute;

import org.openstack4j.api.compute.ComputeSecurityGroupService;
import org.openstack4j.api.compute.ext.HypervisorService;
import org.openstack4j.api.compute.ext.ZoneService;
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

    /**
     * Image Service API
     *
     * @return the image service
     */
    FcComputeImageService images();

    /**
     * ZoneService Extension API
     *
     * @return the zones service
     */
    ZoneService zones();

    /**
     * Hypervisor Service Extension API
     *
     * @return the hypervisor service
     */
    HypervisorService hypervisors();

    ComputeSecurityGroupService securityGroups();

}
