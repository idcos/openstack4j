package org.openstack4j.fusioncloud.compute.internal;

import org.openstack4j.api.Apis;
import org.openstack4j.api.compute.ComputeSecurityGroupService;
import org.openstack4j.api.compute.ext.HypervisorService;
import org.openstack4j.api.compute.ext.ZoneService;
import org.openstack4j.fusionapi.compute.FcComputeImageService;
import org.openstack4j.fusionapi.compute.FcComputeService;
import org.openstack4j.fusionapi.compute.FcFlavorService;
import org.openstack4j.fusionapi.compute.ext.FcHypervisorService;
import org.openstack4j.fusionapi.compute.ext.FcZoneService;


/**
 * @author: liuxs
 * @description: compute openration Api
 * @date: Created in 下午6:27  2018/8/16
 */
public class FcComputeServiceImpl  extends BaseFcComputeServices implements FcComputeService {

    /**
     * {@inheritDoc}
     */
    @Override
    public FcFlavorService flavors() {
        return Apis.get(FcFlavorService.class);
    }

    @Override
    public FcComputeImageService images() {
        return Apis.get(FcComputeImageService.class);
    }

    @Override
    public ZoneService zones() {
         return Apis.get(FcZoneService.class);
    }

    @Override
    public HypervisorService hypervisors() {
        return Apis.get(FcHypervisorService.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputeSecurityGroupService securityGroups() {
        return Apis.get(ComputeSecurityGroupService.class);
    }
}
