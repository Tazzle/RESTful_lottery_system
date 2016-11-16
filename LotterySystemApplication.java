package com.newsweaver.lotterysystem;

import com.newsweaver.lotterysystem.resources.LotteryTicketService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class LotterySystemApplication extends Application<LotterySystemConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LotterySystemApplication().run(args);
    }

    @Override
    public String getName() {
        return "LotterySystem";
    }

    @Override
    public void initialize(final Bootstrap<LotterySystemConfiguration> bootstrap) {
    }

    @Override
    public void run(final LotterySystemConfiguration configuration,
                    final Environment environment) {

        final LotteryTicketService lotteryticketservice = new LotteryTicketService();

        environment.jersey().register(lotteryticketservice);
    }

}
