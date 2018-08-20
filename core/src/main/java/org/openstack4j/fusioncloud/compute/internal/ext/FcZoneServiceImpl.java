package org.openstack4j.fusioncloud.compute.internal.ext;

import org.openstack4j.fusionapi.compute.ext.FcZoneService;
import org.openstack4j.fusioncloud.compute.internal.BaseFcComputeServices;
import org.openstack4j.model.compute.ext.AvailabilityZone;
import org.openstack4j.openstack.compute.domain.ext.ExtAvailabilityZone;

import java.util.List;

/**
 * @author: liuxs
 * @description:
 * @date: Created in 下午2:33  2018/8/20
 */
public class FcZoneServiceImpl extends BaseFcComputeServices implements FcZoneService {
    @Override
    public List<? extends AvailabilityZone> list() {
        return list(Boolean.FALSE);
    }

    @Override
    public List<? extends AvailabilityZone> list(boolean detailed) {
        String uri = (detailed) ? "/os-availability-zone/detail" : "/os-availability-zone";
        return get(ExtAvailabilityZone.AvailabilityZones.class, uri).execute().getList();
    }
}
