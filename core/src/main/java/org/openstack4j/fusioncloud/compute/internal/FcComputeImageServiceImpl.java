package org.openstack4j.fusioncloud.compute.internal;

import org.openstack4j.fusionapi.compute.FcComputeImageService;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.compute.Image;
import org.openstack4j.openstack.compute.domain.MetaDataWrapper;
import org.openstack4j.openstack.compute.domain.NovaImage;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author: liuxs
 * @description: Provides access to Compute Images
 * @date: Created in 上午11:48  2018/8/17
 */
public class FcComputeImageServiceImpl extends BaseFcComputeServices implements FcComputeImageService{

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends Image> list() {
        return list(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends Image> list(boolean detailed) {
        String uri = (detailed) ? "/images/detail" : "/images";
        return get(NovaImage.NovaImages.class, uri(uri)).execute().getList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Image get(String imageId) {
        checkNotNull(imageId);
        return get(NovaImage.class, uri("/images/%s", imageId)).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ActionResponse delete(String imageId) {
        checkNotNull(imageId);
        return deleteWithResponse(uri("/images/%s", imageId)).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> setMetaData(String imageId, Map<String, String> metadata) {
        checkNotNull(imageId);
        checkNotNull(metadata);
        return post(MetaDataWrapper.class, uri("/images/%s/metadata", imageId)).entity(MetaDataWrapper.wrap(metadata)).execute().getMetaData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ActionResponse deleteMetaData(String imageId, String... keys) {
        checkNotNull(imageId);
        for (String k : keys)
        {
            ActionResponse resp  = deleteWithResponse(uri("/images/%s/metadata/%s", imageId, k)).execute();
            if (!resp.isSuccess())
                return resp;
        }
        return ActionResponse.actionSuccess();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> getMetaData(String imageId) {
        checkNotNull(imageId);
        return get(MetaDataWrapper.class, uri("/images/%s/metadata", imageId)).execute().getMetaData();
    }

}
