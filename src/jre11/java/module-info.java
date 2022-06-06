import com.jwebmp.plugins.moment.implementations.MomentIncludeModule;

module com.jwebmp.plugins.moment {

	exports com.jwebmp.plugins.moment;
	
	requires com.jwebmp.core.base.angular.client;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.moment.MomentPageConfigurator;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with MomentIncludeModule;

	opens com.jwebmp.plugins.moment to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.moment.implementations to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
}
