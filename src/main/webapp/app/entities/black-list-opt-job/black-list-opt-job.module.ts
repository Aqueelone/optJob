import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OptJobSharedModule } from '../../shared';
import {
    BlackListOptJobService,
    BlackListOptJobPopupService,
    BlackListOptJobComponent,
    BlackListOptJobDetailComponent,
    BlackListOptJobDialogComponent,
    BlackListOptJobPopupComponent,
    BlackListOptJobDeletePopupComponent,
    BlackListOptJobDeleteDialogComponent,
    blackListRoute,
    blackListPopupRoute,
} from './';

const ENTITY_STATES = [
    ...blackListRoute,
    ...blackListPopupRoute,
];

@NgModule({
    imports: [
        OptJobSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        BlackListOptJobComponent,
        BlackListOptJobDetailComponent,
        BlackListOptJobDialogComponent,
        BlackListOptJobDeleteDialogComponent,
        BlackListOptJobPopupComponent,
        BlackListOptJobDeletePopupComponent,
    ],
    entryComponents: [
        BlackListOptJobComponent,
        BlackListOptJobDialogComponent,
        BlackListOptJobPopupComponent,
        BlackListOptJobDeleteDialogComponent,
        BlackListOptJobDeletePopupComponent,
    ],
    providers: [
        BlackListOptJobService,
        BlackListOptJobPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class OptJobBlackListOptJobModule {}
