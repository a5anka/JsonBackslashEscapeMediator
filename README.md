## JsonBackslashEscapeMediator

This custom class mediator can be used to escape backslash character in 
the JSON payloads.


### Building the project

From the home directory of the project run `mvn clean install`. This will 
download the dependencies into your local repository, build the jar file 
and place it in the `target` directory under the home directory of 
the project.

### Installation

1. Copy the created jar (`JsonBackslashEscapeMediator-1.0-SNAPSHOT.jar`) to 
the `${CARBON_HOME}/repository/components/lib` directory of the ESB nodes you wish to install the custom mediator.
2. Restart the server.


### Usage

You can use the class mediator in ESB to use this class mediator. Sample 
code snippet is mentioned below.

```xml
<class name="org.wso2.synapse.mediators.custom.json.JsonBackslashEscapeMediator"/>
```


