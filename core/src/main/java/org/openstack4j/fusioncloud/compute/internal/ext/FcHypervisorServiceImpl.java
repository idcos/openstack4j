package org.openstack4j.fusioncloud.compute.internal.ext;

import org.openstack4j.fusionapi.compute.ext.FcHypervisorService;
import org.openstack4j.fusioncloud.compute.internal.BaseFcComputeServices;
import org.openstack4j.model.compute.ext.Hypervisor;
import org.openstack4j.model.compute.ext.HypervisorStatistics;
import org.openstack4j.openstack.compute.domain.ext.ExtHypervisor;
import org.openstack4j.openstack.compute.domain.ext.ExtHypervisorStatistics;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author: liuxs
 * @description:
 * @date: Created in 下午3:48  2018/8/20
 */
public class FcHypervisorServiceImpl extends BaseFcComputeServices implements FcHypervisorService{

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends Hypervisor> list() {
        return get(ExtHypervisor.Hypervisors.class, "/os-hypervisors/detail").execute().getList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HypervisorStatistics statistics() {
        return get(ExtHypervisorStatistics.class, "/os-hypervisors/statistics").execute();
    }

    /**
     * <p>Description:Get the specified Hypervisor by ID</p>
     * <p>Author:Wang Ting/王婷</p>
     *
     * @param hypervisorId the UUID of the hypervisor
     * @return the hypervisor
     */
    @Override
    public Hypervisor get(String hypervisorId) {
        checkNotNull(hypervisorId);
        return get(ExtHypervisor.class, uri("/os-hypervisors/%s", hypervisorId)).execute();
    }

}
