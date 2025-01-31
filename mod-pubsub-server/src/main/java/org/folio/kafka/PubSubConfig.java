package org.folio.kafka;

import org.folio.rest.tools.utils.ModuleName;

import static java.lang.String.join;

public class PubSubConfig {
  private static final String PUB_SUB_PREFIX = "pub-sub";
  private String tenant;
  private String eventType;
  private String groupId;
  private String topicName;

  public PubSubConfig(String env, String tenant, String eventType) {
    this.tenant = tenant;
    this.eventType = eventType;
    /* moduleNameWithVersion variable need for unique topic and group names for different pub-sub versions.
    It was encapsulated here, in constructor, for better creating/subscribing/sending events.*/
    String moduleNameWithVersion = ModuleName.getModuleName().replace("_", "-") + "-" + ModuleName.getModuleVersion();
    this.groupId = join(".", env, PUB_SUB_PREFIX, tenant, eventType, moduleNameWithVersion);
    this.topicName = join(".", env, PUB_SUB_PREFIX, tenant, eventType, moduleNameWithVersion);
  }

  public String getTenant() {
    return tenant;
  }

  public String getEventType() {
    return eventType;
  }

  public String getGroupId() {
    return groupId;
  }

  public String getTopicName() {
    return topicName;
  }
}
