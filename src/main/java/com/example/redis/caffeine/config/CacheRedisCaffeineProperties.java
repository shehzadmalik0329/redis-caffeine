package com.example.redis.caffeine.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.cache.multi")
public class CacheRedisCaffeineProperties {

	private Set<String> cacheNames = new HashSet<>();

	/** Whether to store null values, default true, prevent cache penetration*/
	private boolean cacheNullValues = true;

	/** Whether to dynamically create a Cache implementation based on cacheName, default true*/
	private boolean dynamic = true;

	/** Cache key prefix*/
	private String cachePrefix;

	private Redis redis = new Redis();

	private Caffeine caffeine = new Caffeine();

	public class Redis {

		/** Global expiration time, unit milliseconds, default expiration*/
		private long defaultExpiration = 0;

		/** The expiration time per cache Name, in milliseconds, is higher in priority than defaultExpiration*/
		private Map<String, Long> expires = new HashMap<>();

		/** Notify other nodes of the topic name when the cache is updated*/
		private String topic = "cache:redis:caffeine:topic";

		public long getDefaultExpiration() {
			return defaultExpiration;
		}

		public void setDefaultExpiration(long defaultExpiration) {
			this.defaultExpiration = defaultExpiration;
		}

		public Map<String, Long> getExpires() {
			return expires;
		}

		public void setExpires(Map<String, Long> expires) {
			this.expires = expires;
		}

		public String getTopic() {
			return topic;
		}

		public void setTopic(String topic) {
			this.topic = topic;
		}

	}

	public class Caffeine {

		/** Post-access expiration time, in milliseconds*/
		private long expireAfterAccess;

		/** Post-write expiration time, in milliseconds*/
		private long expireAfterWrite;

		/** Refresh time per millisecond after writing*/
		private long refreshAfterWrite;

		/** Initialization size*/
		private int initialCapacity;

		/** Maximum number of cached objects, beyond which caches placed before will fail*/
		private long maximumSize;

		/** Because the weight needs to be provided by the cache object, it is not suitable for the scenario of using spring cache, so configuration is not supported for the time being.*/
		//		private long maximumWeight;

		public long getExpireAfterAccess() {
			return expireAfterAccess;
		}

		public void setExpireAfterAccess(long expireAfterAccess) {
			this.expireAfterAccess = expireAfterAccess;
		}

		public long getExpireAfterWrite() {
			return expireAfterWrite;
		}

		public void setExpireAfterWrite(long expireAfterWrite) {
			this.expireAfterWrite = expireAfterWrite;
		}

		public long getRefreshAfterWrite() {
			return refreshAfterWrite;
		}

		public void setRefreshAfterWrite(long refreshAfterWrite) {
			this.refreshAfterWrite = refreshAfterWrite;
		}

		public int getInitialCapacity() {
			return initialCapacity;
		}

		public void setInitialCapacity(int initialCapacity) {
			this.initialCapacity = initialCapacity;
		}

		public long getMaximumSize() {
			return maximumSize;
		}

		public void setMaximumSize(long maximumSize) {
			this.maximumSize = maximumSize;
		}
	}

	public Set<String> getCacheNames() {
		return cacheNames;
	}

	public void setCacheNames(Set<String> cacheNames) {
		this.cacheNames = cacheNames;
	}

	public boolean isCacheNullValues() {
		return cacheNullValues;
	}

	public void setCacheNullValues(boolean cacheNullValues) {
		this.cacheNullValues = cacheNullValues;
	}

	public boolean isDynamic() {
		return dynamic;
	}

	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}

	public String getCachePrefix() {
		return cachePrefix;
	}

	public void setCachePrefix(String cachePrefix) {
		this.cachePrefix = cachePrefix;
	}

	public Redis getRedis() {
		return redis;
	}

	public void setRedis(Redis redis) {
		this.redis = redis;
	}

	public Caffeine getCaffeine() {
		return caffeine;
	}

	public void setCaffeine(Caffeine caffeine) {
		this.caffeine = caffeine;
	}

}
