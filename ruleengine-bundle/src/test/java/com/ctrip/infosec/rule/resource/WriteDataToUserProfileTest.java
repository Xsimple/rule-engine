package com.ctrip.infosec.rule.resource;

import com.ctrip.infosec.rule.action.WriteDataToUserProfile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lpxie on 15-4-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/counter-venus-test.xml"})
public class WriteDataToUserProfileTest
{
    @Test
    public void testWriteData()
    {
        Map values = new HashMap();
        values.put("MOB_BOUND","13917863756");
        values.put("RECENT_IP","112.112.113.114");
        String pkgValue = "wwwwww";
        int storeType = 2;
        Map result = WriteDataToUserProfile.writeData(values,pkgValue,storeType);
        Assert.assertNotNull(result);
    }

    @Test
    public void testReadData()
    {
        List tags = new ArrayList();
        tags.add("\"MOB_BOUND\"");
        tags.add("\"RECENT_IP\"");
        String pkgValue = "wwwwww";
        int storeType = 2;
        int length = 1;

        Map result = WriteDataToUserProfile.readData(tags, pkgValue, storeType, length);
        Assert.assertNotNull(result);
    }
}
