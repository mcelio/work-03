package org.vectorx.metrics;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlet.InstrumentedFilterContextListener;

/**
 * Class listens to the context and integrate with metrics provision.
 * 
 * @author Marcos
 *
 */
public class MyInstrumentedFilterContextListener extends InstrumentedFilterContextListener {
   
	public static final MetricRegistry REGISTRY = new MetricRegistry();

    @Override
    protected MetricRegistry getMetricRegistry() {
        return REGISTRY;
    }
}
