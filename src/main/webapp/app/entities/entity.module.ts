import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { OptJobEventOptJobModule } from './event-opt-job/event-opt-job.module';
import { OptJobPublisherOptJobModule } from './publisher-opt-job/publisher-opt-job.module';
import { OptJobCampaignOptJobModule } from './campaign-opt-job/campaign-opt-job.module';
import { OptJobOptimizationPropsOptJobModule } from './optimization-props-opt-job/optimization-props-opt-job.module';
import { OptJobBlackListOptJobModule } from './black-list-opt-job/black-list-opt-job.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        OptJobEventOptJobModule,
        OptJobPublisherOptJobModule,
        OptJobCampaignOptJobModule,
        OptJobOptimizationPropsOptJobModule,
        OptJobBlackListOptJobModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class OptJobEntityModule {}
