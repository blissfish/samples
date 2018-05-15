package caching.sample;


import static java.util.Collections.singletonList;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.web.WebFilter;

@Configuration
public class HazelcastConfiguration  {
	
//	   @Bean
//	    public Config hazelCastConfig(){
//	        return new Config()
//	                .setInstanceName("hazelcast-instance")
//	                .addMapConfig(
//	                        new MapConfig()
//	                                .setName("data")
//	                                .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
//	                                .setEvictionPolicy(EvictionPolicy.LRU)
//	                                .setTimeToLiveSeconds(20));
//	    }
	   
	    @Bean
	    public Config config() {

	        Config config = new Config();

	        JoinConfig joinConfig = config.getNetworkConfig().getJoin();

	        joinConfig.getMulticastConfig().setEnabled(false);
	        joinConfig.getTcpIpConfig().setEnabled(true).setMembers(singletonList("127.0.0.1"));

	        return config;
	    }
	    
	    @Bean
	    public WebFilter webFilter(HazelcastInstance hazelcastInstance) {

	        Properties properties = new Properties();
	        properties.put("instance-name", hazelcastInstance.getName());
	        properties.put("sticky-session", "false");

	        return new WebFilter(properties);
	    }
} 