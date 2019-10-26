module com.jwebmp.plugins.moment {

	exports com.jwebmp.plugins.moment;

	requires com.jwebmp.core;
	requires com.guicedee.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires java.logging;
	requires com.guicedee.guicedinjection;
	requires com.jwebmp.core.angularjs;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.moment.MomentPageConfigurator;

	provides com.guicedee.guicedinjection.interfaces.IGuiceScanJarExclusions with com.jwebmp.plugins.moment.implementations.MomentExclusionsModule;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.moment.implementations.MomentExclusionsModule;

	provides com.jwebmp.core.base.angular.services.IAngularModule with com.jwebmp.plugins.moment.implementations.MomentAngularModule;

	opens com.jwebmp.plugins.moment to com.fasterxml.jackson.databind, com.jwebmp.core,com.google.guice;
	opens com.jwebmp.plugins.moment.implementations to com.fasterxml.jackson.databind, com.jwebmp.core,com.google.guice;
}
