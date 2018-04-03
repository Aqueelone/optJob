import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OptJobSharedModule } from '../../shared';
import {
    PublisherOptJobService,
    PublisherOptJobPopupService,
    PublisherOptJobComponent,
    PublisherOptJobDetailComponent,
    PublisherOptJobDialogComponent,
    PublisherOptJobPopupComponent,
    PublisherOptJobDeletePopupComponent,
    PublisherOptJobDeleteDialogComponent,
    publisherRoute,
    publisherPopupRoute,
} from './';

const ENTITY_STATES = [
    ...publisherRoute,
    ...publisherPopupRoute,
];

@NgModule({
    imports: [
        OptJobSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        PublisherOptJobComponent,
        PublisherOptJobDetailComponent,
        PublisherOptJobDialogComponent,
        PublisherOptJobDeleteDialogComponent,
        PublisherOptJobPopupComponent,
        PublisherOptJobDeletePopupComponent,
    ],
    entryComponents: [
        PublisherOptJobComponent,
        PublisherOptJobDialogComponent,
        PublisherOptJobPopupComponent,
        PublisherOptJobDeleteDialogComponent,
        PublisherOptJobDeletePopupComponent,
    ],
    providers: [
        PublisherOptJobService,
        PublisherOptJobPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class OptJobPublisherOptJobModule {}
