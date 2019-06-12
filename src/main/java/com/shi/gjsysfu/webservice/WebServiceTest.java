package com.shi.gjsysfu.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import java.util.Date;
/**
 * webservice客户端
 * 
 * 
 * @author：WangYuanJun
 * @date：2017年12月19日 下午9:39:49
 */
public class WebServiceTest {

    public static void main(String args[]){
            // 创建动态客户端
            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
            Client client = dcf.createClient("http://localhost:8080/services/Tb_OrdersServices?wsdl");
            Object[] objects = new Object[10];
                TbQing tbQing = new TbQing();
                tbQing.setOrdersNo("or0014");
                tbQing.setWaybillNo("wl0014");
                tbQing.setQingNo("qd0014");
                tbQing.setPayNo("pa0014");
                tbQing.setStauts(null);
                tbQing.setCreateTime(new Date());
                String data = GsonUtil.gsonString(tbQing);
            try
            {
                // invoke("方法名",参数1,参数2,参数3....);
                objects = client.invoke("checkNo","1003",data);
                System.out.println("返回数据:" + objects[0]);
            } catch (Exception e)
            {

                e.printStackTrace();
            }

        }
}
