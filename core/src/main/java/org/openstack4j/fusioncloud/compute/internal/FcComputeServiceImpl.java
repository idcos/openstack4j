package org.openstack4j.fusioncloud.compute.internal;

import org.openstack4j.api.Apis;
import org.openstack4j.fusionapi.compute.FcComputeService;
import org.openstack4j.fusionapi.compute.FcFlavorService;


/**
 * @author: liuxs
 * @description:
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
}
