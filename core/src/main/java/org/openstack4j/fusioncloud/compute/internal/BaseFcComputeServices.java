package org.openstack4j.fusioncloud.compute.internal;

import org.openstack4j.api.types.ServiceType;
import org.openstack4j.core.transport.HttpResponse;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.openstack.compute.domain.actions.ServerAction;
import org.openstack4j.openstack.compute.functions.ToActionResponseFunction;
import org.openstack4j.openstack.internal.BaseOpenStackService;

/**
 * @author: liuxs
 * @description: Base Class for fusionCloud compute
 * @date: Created in 下午3:02  2018/8/16
 */
public class BaseFcComputeServices extends BaseOpenStackService {

    protected BaseFcComputeServices() {
        super(ServiceType.FUSION_COMPUTE);
    }

    protected ActionResponse invokeAction(String serverId, ServerAction action)  {
        return ToActionResponseFunction.INSTANCE.apply(invokeActionWithResponse(serverId, action), action.getClass().getName());
    }

    protected HttpResponse invokeActionWithResponse(String serverId, ServerAction action)  {
        HttpResponse response  = post(Void.class, uri("/servers/%s/action", serverId))
                .entity(action)
                .executeWithResponse();
        return response;
    }
}
